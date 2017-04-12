package com.zjw.blog.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author belldog
 * 
 */
public abstract class Validators {

	/** Check whether string s is null */
	public static boolean isNull(Object s) {
		return (s == null);
	}

	/** Check whether string s is NOT null */
	public static boolean isNotNull(Object s) {
		return (s != null);
	}

	/** Check whether string s is null */
	public static boolean isNull(String s) {
		return (s == null);
	}

	/** Check whether string s is NOT null */
	public static boolean isNotNull(String s) {
		return (s != null);
	}

	/** Check whether strings is empty. */
	public static boolean isEmpty(String s) {
		return ((s == null) || (s.length() == 0));
	}

	/** Check whether collection c is empty. */
	public static boolean isEmpty(Collection<?> c) {
		return ((c == null) || (c.size() == 0));
	}

	/** Check whether string s is NOT empty. */
	public static boolean isNotEmpty(String s) {
		return ((s != null) && (s.length() > 0));
	}

	/** Check whether collection c is NOT empty. */
	public static boolean isNotEmpty(Collection<?> c) {
		return ((c != null) && (c.size() > 0));
	}

	/** Check whether Object c is a String. */
	public static boolean isString(Object obj) {
		return ((obj != null) && (obj instanceof String));
	}

	/** Check whether Map map is empty. */
	public static boolean isEmpty(Map<?, ?> map) {
		return ((map == null) || map.isEmpty());
	}

	/** Check whether String[] s is empty */
	public static boolean isEmpty(String[] s) {
		return ((s == null) || (s.length == 0));
	}

	/** Check whether String[] s is NOT empty */
	public static boolean isNotEmpty(String[] s) {
		return ((s != null) && (s.length > 0));
	}

	/** Check whether a trimed String s is empty */
	public static boolean isTrimEmpty(String s) {
		return ((s == null) || (s.trim().length() == 0));
	}

	/**
	 * Returns true if all characters are correct email format
	 */
	public static boolean isEmail(String email) {
		return email != null && email.matches("^[a-zA-Z0-9_\\.\\-]+\\@([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9]{2,4}$");
	}

	/**
	 * Return true if all characters are correct URL format
	 */
	public static boolean isUrl(String url) {
		return url != null && url.matches("http://([w-]+.)+[w-]+(/[w- ./?%&=]*)?");
	}

	/** Check whether Array array is empty */
	public static boolean isEmptyArray(Object array) {
		if (null == array)
			return true;
		if (array.getClass().isArray())
			return Array.getLength(array) == 0;
		return false;
	}

	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an array of Objects is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive longs is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(long[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive ints is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive shorts is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(short[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive chars is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(char[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive doubles is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(double[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive floats is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(float[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive booleans is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(boolean[] array) {
		return array == null || array.length == 0;
	}

	// ----------------------------------------------------------------------
	/**
	 * <p>
	 * Checks if an array of Objects is not empty or not {@code null}.
	 * </p>
	 *
	 * @param <T>
	 *            the component type of the array
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive longs is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(long[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive ints is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(int[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive shorts is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(short[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive chars is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(char[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(byte[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive doubles is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(double[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive floats is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(float[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive booleans is not empty or not {@code null}
	 * .
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(boolean[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 *
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer trims the
	 * CharSequence. That functionality is available in isBlank().
	 * </p>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is empty or null
	 * @since 3.0 Changed signature from isEmpty(String) to
	 *        isEmpty(CharSequence)
	 */
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isStringNotEmpty(Object stringObject) {
		return isNotNull(stringObject) && isNotEmpty(stringObject.toString());
	}

}
