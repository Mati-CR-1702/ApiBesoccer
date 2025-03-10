package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMatchDto {

        private Boolean success;
        private List<Categoria> data;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public List<Categoria> getData() {
            return data;
        }

        public void setData(List<Categoria> data) {
            this.data = data;
        }

    }
