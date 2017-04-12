package com.zjw.blog.base;

/**
 * 基本的控制器.
 *
 * @author belldog
 * @create 2017-04-12  16:44
 */
public abstract class BaseController {

    protected String showView(String viewName) {
        return String.format(getViewBasePath() + viewName);
    }

    protected String showView(String viewName, Object... params) {
        return String.format(getViewBasePath() + viewName, params);
    }

    protected String redirect(String viewName) {
        return String.format("redirect:" + getURLBasePath() + viewName);
    }

    protected String redirect(String viewName, Object... params) {
        return String.format("redirect:" + getURLBasePath() + viewName, params);
    }

    protected String redirectURL(String url) {
        return String.format("redirect:" + url);
    }

    protected String getViewBasePath() {
        return "";
    }


    protected String getURLBasePath() {
        return "";
    }

}
