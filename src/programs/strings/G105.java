/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.strings;

class Node {
    public Node parent = null;
    public Node[] child = new Node[29];
    public Node prev = null;
    public Node next = null;
    public char data = ' ';
    public int count = 0;
}

public class G105 {
    public static String firstUnique(String[] array) {
        Node root = new Node();
        Node first = null;
        Node last = null;
        for (String s : array) {
            Node current = root;
            /* Modify the trie */
            for (char c : s.toCharArray()) {
                int index = 0;
                if (':' == c) {
                    index = 28;
                } else if ('/' == c) {
                    index = 27;
                } else if ('.' == c) {
                    index = 26;
                } else {
                    index = c - 'a';
                }

                if (null == current.child[index]) {
                    Node next = new Node();
                    next.parent = current;
                    next.data = c;
                    current.child[index] = next;
                }
                current = current.child[index];
            }

            /* Modify the linked list */
            current.count++;
            if (1 == current.count) {
                if (null == first) {
                    first = last = current;
                } else {
                    current.prev = last;
                    last.next = current;
                    last = current;
                }
            } else if (2 == current.count) {
                if (current == first) {
                    first = current.next;
                    if (null != first) {
                        first.prev = null;
                    }
                } else {
                    Node prev = current.prev;
                    prev.next = current.next;
                    if (null != current.next) {
                        current.next.prev = prev;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        Node current = first;
        while (current != root) {
            sb.append(current.data);
            current = current.parent;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String[] urls = {
                "abc.google.com",
                "abc.facebook.com",
                "abc.amazon.com",
                "abc.yahoo.com",
                "abc.facebook.com",
                "abc.yahoo.com",
                "abc.facebook.com",
                "abc.google.com"
        };
        System.out.println(firstUnique(urls));
    }
}