package com.quick.java.sync;

import java.util.concurrent.Semaphore;

/**
 * Created on 9/30/14.
 */
public class SemaphoreTest {
  public static final Semaphore sema = new Semaphore(3);
  public static void main(String[] args) throws InterruptedException {
    System.out.println(sema.toString());
    sema.release();
    sema.release();
    sema.release();
    System.out.println(sema.toString());
    sema.acquire();
    System.out.println(sema.toString());
    sema.acquire();
    System.out.println(sema.toString());
    sema.acquire();
    System.out.println(sema.toString());
    sema.acquire();
    System.out.println(sema.toString());
  }
}
