package programs.leetcode

fun removeSubfolders(folder: Array<String>): List<String> {
    // Step 1: Sort folders lexicographically
    folder.sort()

    val result = mutableListOf<String>()

    // Step 2: Iterate through the sorted list
    for (f in folder) {
        // If the result is empty or the current folder is not a sub-folder of the last added folder
        if (result.isEmpty() || !f.startsWith(result.last() + "/")) {
            result.add(f)
        }
    }

    return result
}

// Example usage:
fun main() {
    val folder1 = arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
    val folder2 = arrayOf("/a", "/a/b/c", "/a/b/d")
    val folder3 = arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")

    println(removeSubfolders(folder1))  // Output: ["/a", "/c/d", "/c/f"]
    println(removeSubfolders(folder2))  // Output: ["/a"]
    println(removeSubfolders(folder3))  // Output: ["/a/b/c", "/a/b/ca", "/a/b/d"]
}
