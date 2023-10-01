package com.laptrinhjavaweb.payment.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractProcess<T, V>{
    protected Execute execute = new Execute();

    public AbstractProcess() {
    }

    public Execute getExecute() {
        return execute;
    }

    public void setExecute(Execute execute) {
        this.execute = execute;
    }

    public static Gson getGson() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .create();
    }

    public static void errorProcess(int errorCode) throws Exception {
        switch (errorCode) {
            case 0:
                // O is meaning success
                break;
            case 1:
                throw new Exception("Empty access key or partner code");
        }
    }


    public abstract V execute(String url);
}
