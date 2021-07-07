package com.chenyacheng.androidjetpack.ui.viewmodel;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyacheng
 * @date 2021/07/05
 */
public class BasicThreadFactory implements ThreadFactory {

    private final AtomicLong threadCounter;
    private final ThreadFactory wrappedFactory;
    private final String namingPattern;
    private final Boolean daemonFlag;

    private BasicThreadFactory(Builder builder) {
        wrappedFactory = Executors.defaultThreadFactory();
        namingPattern = builder.namingPattern;
        daemonFlag = builder.daemonFlag;
        threadCounter = new AtomicLong();
    }

    public final ThreadFactory getWrappedFactory() {
        return wrappedFactory;
    }

    public final String getNamingPattern() {
        return namingPattern;
    }

    public final Boolean getDaemonFlag() {
        return daemonFlag;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = getWrappedFactory().newThread(r);
        initializeThread(t);
        return t;
    }

    private void initializeThread(Thread t) {
        if (getNamingPattern() != null) {
            Long count = threadCounter.incrementAndGet();
            t.setName(String.format(getNamingPattern(), count));
        }
        if (getDaemonFlag() != null) {
            t.setDaemon(getDaemonFlag());
        }
    }


    public static class Builder {

        /**
         * The naming pattern.
         */
        private String namingPattern;

        /**
         * The daemon flag.
         */
        private Boolean daemonFlag;

        public Builder namingPattern(String pattern) {
            if (pattern == null) {
                throw new NullPointerException("Naming pattern must not be null!");
            }
            namingPattern = pattern;
            return this;
        }

        public Builder daemon(boolean on) {
            daemonFlag = on;
            return this;
        }

        private void reset() {
            namingPattern = null;
            daemonFlag = null;
        }

        public BasicThreadFactory build() {
            BasicThreadFactory factory = new BasicThreadFactory(this);
            reset();
            return factory;
        }
    }
}
