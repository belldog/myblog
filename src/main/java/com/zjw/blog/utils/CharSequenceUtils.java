/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zjw.blog.utils;

/**
 * <p>Operations on {@link CharSequence} that are
 * {@code null} safe.</p>
 *
 * @see CharSequence
 * @since 3.0
 * @version $Id: CharSequenceUtils.java 1199894 2011-11-09 17:53:59Z ggregory $
 */
public class CharSequenceUtils {

    /**
     * <p>{@code CharSequenceUtils} instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public CharSequenceUtils() {
        super();
    }

    //-----------------------------------------------------------------------
    /**
     *
     * <p>CharSequence是一个接口，其中如String，StringBuffer等类实现了该接口</p>
     * <p>该方法截取从start开始到末尾的CharSequence</p>
     * @param cs  the specified subsequence, null returns null
     * @param start  the start index, inclusive, valid
     * @return a new subsequence, may be null
     * @throws IndexOutOfBoundsException if {@code start} is negative or if 
     *  {@code start} is greater than {@code length()}
     */
    public static CharSequence subSequence(CharSequence cs, int start) {
        return cs == null ? null : cs.subSequence(start, cs.length());
    }

    //-----------------------------------------------------------------------
    /**
     * <p>从指定的索引start开始搜索，返回在此字符串中第一次出现指定字符searchChar处的索引.找不到返回-1</p>
     *
     * @param cs  the {@code CharSequence} to be processed, not null
     * @param searchChar  the char to be searched for
     * @param start  the start index, negative starts at the string start
     * @return the index where the search char was found, -1 if not found
     */
    static int indexOf(CharSequence cs, int searchChar, int start) {
        if (cs instanceof String) {
            return ((String) cs).indexOf(searchChar, start);
        } else {
            int sz = cs.length();
            if (start < 0) {
                start = 0;
            }
            for (int i = start; i < sz; i++) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 从指定的索引处start开始，返回第一次出现的指定子CharSequence在此CharSequence中的索引
     *
     * @param cs the {@code CharSequence} to be processed
     * @param searchChar the {@code CharSequence} to be searched for
     * @param start the start index
     * @return the index where the search sequence was found
     */
    static int indexOf(CharSequence cs, CharSequence searchChar, int start) {
        return cs.toString().indexOf(searchChar.toString(), start);
    }

    /**
     * <p>指定 Unicode 字符searchChar在此实例中的最后一个匹配项的索引位置。
     * 该搜索从指定字符位置start开始。</p>
     *
     * @param cs  the {@code CharSequence} to be processed
     * @param searchChar  the char to be searched for
     * @param start  the start index, negative returns -1, beyond length starts at end
     * @return the index where the search char was found, -1 if not found
     */
    static int lastIndexOf(CharSequence cs, int searchChar, int start) {
        if (cs instanceof String) {
            return ((String) cs).lastIndexOf(searchChar, start);
        } else {
            int sz = cs.length();
            if (start < 0) {
                return -1;
            }
            if (start >= sz) {
                start = sz - 1;
            }
            for (int i = start; i >= 0; --i) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 指定 子CharSequence searchChar在此实例cs中的最后一个匹配项的索引位置。
     * 该搜索从指定字符位置start开始。
     *
     * @param cs the {@code CharSequence} to be processed
     * @param searchChar the {@code CharSequence} to be searched for
     * @param start the start index
     * @return the index where the search sequence was found
     */
    static int lastIndexOf(CharSequence cs, CharSequence searchChar, int start) {
        return cs.toString().lastIndexOf(searchChar.toString(), start);
    }

    /**
     * 把这个CharSequence转换成一个新的字符数组
     *
     * @param cs the {@code CharSequence} to be processed
     * @return the resulting char array
     */
    static char[] toCharArray(CharSequence cs) {
        if (cs instanceof String) {
            return ((String) cs).toCharArray();
        } else {
            int sz = cs.length();
            char[] array = new char[cs.length()];
            for (int i = 0; i < sz; i++) {
                array[i] = cs.charAt(i);
            }
            return array;
        }
    }

    /**
     * 是否忽略大小写比较cs从索引为thisStart和substring从索引为start,一共比较length对字符
     *
     * @param cs the {@code CharSequence} to be processed
     * @param ignoreCase whether or not to be case insensitive
     * @param thisStart the index to start on the {@code cs} CharSequence
     * @param substring the {@code CharSequence} to be looked for
     * @param start the index to start on the {@code substring} CharSequence
     * @param length character length of the region
     * @return whether the region matched
     */
    static boolean regionMatches(CharSequence cs, boolean ignoreCase, int thisStart,
            CharSequence substring, int start, int length)    {
        if (cs instanceof String && substring instanceof String) {
            return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
        } else {
            return cs.toString().regionMatches(ignoreCase, thisStart, substring.toString(), start, length);
        }
    }

}
