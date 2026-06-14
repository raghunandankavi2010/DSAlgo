package programs.leetcode

import java.util.PriorityQueue

/*
 * This was a hard problem. Getting the intution was hard. I was thinking why heaps
 * cause if you have n rooms. it is ordered form 0 to n. But we need to keep track of rooms
 * that are available and minimum. If we have to do this linearly that would take lot of time
 * Instead we use two heaps one for rooms availability and the  busy rooms.
 * I would not say i enjoyed solving this on my own. Took google help
 * ============================================================================
 * PROBLEM DESCRIPTION: LeetCode 2402 - Meeting Rooms III (Google Onsite)
 * ============================================================================
 * You are given an integer `n` representing rooms numbered `0` to `n - 1`.
 * You are also given a 2D array `meetings` where meetings[i] = [start_i, end_i),
 * representing a half-closed time interval. All original start times are unique.
 * * Rules for allocation:
 * 1. Each meeting takes place in the unused room with the lowest room number.
 * 2. If no rooms are available, the meeting is delayed until a room becomes free.
 * 3. A delayed meeting preserves its original duration (Duration = End - Start).
 * 4. When a room opens up, the delayed meeting with the earliest *original* * start time gets priority.
 * 5. If multiple rooms free up at the same time, pick the lowest room number.
 * * Goal: Return the room number that held the most meetings. If there's a tie,
 * return the lowest room number among them.
 * * ============================================================================
 * THE INTUITION & APPROACH
 * ============================================================================
 * Treating time as a continuous timeline or running an incrementing loop (t++)
 * is too slow because time stamps can scale up to huge values. Instead, we use
 * an "Event-Driven Simulation" powered by two Min-Heaps.
 * * We process meetings chronologically by sorting them on their start times.
 * As each meeting arrives, we need to make two fast decisions:
 * 1. Which rooms are completely idle right now? (Prioritizing lowest Room ID)
 * 2. If all rooms are packed, which room frees up next? (Prioritizing earliest End Time)
 * * To solve this optimally without linear O(N) searches, we maintain:
 * - `freeRooms` (Min-Heap of Int): Tracks idle rooms. The top of the heap is
 * always the lowest available room index.
 * - `busyRooms` (Min-Heap of Objects): Tracks active rooms, sorted primarily
 * by their `endTime`. If two rooms finish simultaneously, it breaks ties
 * by the lower room index.
 * * ============================================================================
 * SIMULATION STEP-BY-STEP (Per Meeting)
 * ============================================================================
 * For every meeting `[start, end]`:
 * * Step 1: Release Finished Rooms
 * Check `busyRooms`. Any room with an `endTime <= start` has finished its task.
 * Evict it from `busyRooms` and move its index over to `freeRooms`.
 * * Step 2: Allocate Room
 * - Scenario A (Room available): If `freeRooms` is not empty, pop the top room ID.
 * Increment its counter. Schedule it to remain busy until the current meeting's
 * original `end` time. Push it into `busyRooms`.
 * * - Scenario B (No room available - Delay): If `freeRooms` is empty, look at the
 * top of `busyRooms`. This room finishes earliest at `earliestFreeTime`.
 * The delayed meeting is forced to start at `earliestFreeTime`.
 * Its new end time becomes: `earliestFreeTime + (end - start)`.
 * Pop this room, increment its counter, update its new end time, and push it
 * back into `busyRooms`.
 */

/**
 * Represents a room currently hosting a meeting.
 * Ordered primarily by the time the room becomes free, and secondarily by its ID.
 */
data class BusyRoom(
    val endTime: Long,
    val roomNumber: Int
) : Comparable<BusyRoom> {
    override fun compareTo(other: BusyRoom): Int {
        if (this.endTime != other.endTime) {
            return this.endTime.compareTo(other.endTime)
        }
        return this.roomNumber.compareTo(other.roomNumber)
    }
}

fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    // Step 1: Chronological sort based on original arrival times
    meetings.sortBy { it[0] }

    val meetingCount = IntArray(n)

    // Min-Heap initialized with all available rooms [0, 1, ..., n-1]
    val freeRooms = PriorityQueue<Int>()
    for (i in 0 until n) {
        freeRooms.add(i)
    }

    // Min-Heap tracking active allocations sorted by earliest availability
    val busyRooms = PriorityQueue<BusyRoom>()

    // Step 2: Run the event simulation loop
    for (meeting in meetings) {
        val start = meeting[0].toLong()
        val end = meeting[1].toLong()
        val duration = end - start

        // A. Evict rooms that cleared up before or exactly at the current start time
        while (busyRooms.isNotEmpty() && busyRooms.peek().endTime <= start) {
            val freedRoom = busyRooms.poll()
            freeRooms.add(freedRoom.roomNumber)
        }

        // B. Determine placement based on resource availability
        if (freeRooms.isNotEmpty()) {
            // Case 1: Grab the lowest index room immediately available
            val assignedRoom = freeRooms.poll()
            meetingCount[assignedRoom]++
            busyRooms.add(BusyRoom(endTime = end, roomNumber = assignedRoom))
        } else {
            // Case 2: No rooms free. Extract the room that frees up earliest
            val earliestRoom = busyRooms.poll()
            meetingCount[earliestRoom.roomNumber]++

            // The delayed meeting preserves its duration and shifts forward
            val newEndTime = earliestRoom.endTime + duration
            busyRooms.add(BusyRoom(endTime = newEndTime, roomNumber = earliestRoom.roomNumber))
        }
    }

    // Step 3: Scan the tracker array for the max value (lowest index breaks ties)
    var maxMeetings = -1
    var resultRoom = -1
    for (i in 0 until n) {
        if (meetingCount[i] > maxMeetings) {
            maxMeetings = meetingCount[i]
            resultRoom = i
        }
    }

    return resultRoom
}


// ─── Driver Program ──────────────────────────────────────────────────────────

fun main() {


    println("--- Test Case 1: The Visualized Example ---")
    val n1 = 2
    val meetings1 = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(1, 5),
        intArrayOf(2, 7),
        intArrayOf(3, 4)
    )
    val result1 = mostBooked(n1, meetings1)
    println("Room that held the most meetings: Room $result1")
    println("Expected output: Room 0")
    println()

    println("--- Test Case 2: Cascade Delays and Ties ---")
    val n2 = 3
    val meetings2 = arrayOf(
        intArrayOf(1, 20),
        intArrayOf(2, 10),
        intArrayOf(3, 5),
        intArrayOf(4, 9),
        intArrayOf(6, 8)
    )
    // Detailed analysis for Test Case 2:
    // [1,20] -> Room 0 (busy until 20)
    // [2,10] -> Room 1 (busy until 10)
    // [3,5]  -> Room 2 (busy until 5)
    // [4,9]  -> At t=4, Room 2 frees up at t=5. It delays [4,9] to [5,10) in Room 2.
    // [6,8]  -> At t=6, Room 2 freed at t=10. Room 1 freed at t=10. Both Room 1 and 2 free up at 10.
    //           Meeting [6,8] selects Room 1 (lower index tie-breaker) running [10,12).
    // Final Tallies: Room 0 = 1, Room 1 = 2, Room 2 = 2. Lowest index tie-breaker wins -> Room 1.

    val result2 = mostBooked(n2, meetings2)
    println("Room that held the most meetings: Room $result2")
    println("Expected output: Room 1")
}