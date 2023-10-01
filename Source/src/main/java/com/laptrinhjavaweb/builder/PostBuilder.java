package com.laptrinhjavaweb.builder;

public class PostBuilder {
    private String shortTitle;
    private String blogConfiguration;
    private String type;

    public PostBuilder(Builder builder) {
        this.shortTitle = builder.shortTitle;
        this.blogConfiguration = builder.blogConfiguration;
        this.type = builder.type;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getBlogConfiguration() {
        return blogConfiguration;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private String shortTitle;
        private String blogConfiguration;
        private String type;

        public Builder setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
            return this;
        }

        public Builder setBlogConfiguration(String blogConfiguration) {
            this.blogConfiguration = blogConfiguration;
            return this;
        }

        public PostBuilder build() {
            return new PostBuilder(this);
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }
    }
}
