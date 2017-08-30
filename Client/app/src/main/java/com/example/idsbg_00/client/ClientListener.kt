package com.example.idsbg_00.client

import org.apache.mina.core.service.IoService
import org.apache.mina.core.service.IoServiceListener
import org.apache.mina.core.session.IdleStatus
import org.apache.mina.core.session.IoSession

/**
 * Created by cuiduo on 2017/7/22.
 */
class ClientListener : IoServiceListener {
//    val logger = LoggerFactory.getLogger(javaClass.simpleName)!!
    override fun sessionDestroyed(p0: IoSession?) {
    System.out.println("sessionDestroyed")
    }

    override fun serviceActivated(p0: IoService?) {
        System.out.println("serviceActivated")
    }

    override fun serviceDeactivated(p0: IoService?) {
        System.out.println("serviceDeactivated")
    }

    override fun sessionClosed(p0: IoSession?) {
        System.out.println("sessionClosed")    }

    override fun sessionCreated(p0: IoSession?) {
        System.out.println("sessionCreated")    }

    override fun serviceIdle(p0: IoService?, p1: IdleStatus?) {
        System.out.println("serviceIdle")    }
}