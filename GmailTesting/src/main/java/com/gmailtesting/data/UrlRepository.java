package com.gmailtesting.data;

public final class UrlRepository {

    public static enum Urls {
        GMAIL_HOST("http://www.gmail.com");

        private String field;

        private Urls(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private UrlRepository() {
    }

}