package com.test.foundationlib.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 *  Activity  Management
 */
class AppManager private constructor(){

    private val activityStack:Stack<Activity> = Stack()

    companion object {
        val instance:AppManager by lazy { AppManager() }
    }

    /**
     *  Activity In
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /**
     *  Activity Out
     */
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }


    /**
     * Get the top stack Activity
     */
    fun currentActivity():Activity{
        return activityStack.lastElement()
    }


    /**
     * Clear Activity Stack
     */
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }


    /**
     * Exit App
     *
     */
    fun exitApp(context:Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}
