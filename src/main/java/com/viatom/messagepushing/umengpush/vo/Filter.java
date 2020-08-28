package com.viatom.messagepushing.umengpush.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiujiawei
 * @description Filter
 * @date 2020/8/24 17:55
 */
@Data
public class Filter {

    private final Map<String, List<Map<String, Object>>> where;

    Filter(Builder builder) {
        this.where = builder.where;
    }



    public static final class Builder {
        final Map<String, List<Map<String, Object>>> where = new HashMap<>();
        final List<Map<String, Object>> and = new ArrayList<>();
        final int initialCapacity = 1;
        public Builder() {
            this.where.put("and", and);
        }

        public Builder and(String filterField, String value) {
            Map<String, Object> map = new HashMap<>(initialCapacity);
            map.put(filterField, value);
            and.add(map);
            return this;
        }

        @SuppressWarnings("unchecked")
        public Builder or(String filterField, String value) {
            List<Map<String,Object>> orList = null;
            //判断and list里面存不存在key为or的map
            for (Map<String, Object> map : and) {
                if (map.containsKey("or")) {
                    orList = (List<Map<String,Object>>) map.get("or");
                    break;
                }
            }
            //and list里面不存在key为or的map，则新建一个map
            if (orList == null) {
                orList = new ArrayList<>();
                Map<String, Object> orMap = new HashMap<>(initialCapacity);
                orMap.put("or",orList);
                and.add(orMap);
            }

            Map<String, Object> map = new HashMap<>(initialCapacity);
            map.put(filterField, value);
            orList.add(map);

            return this;
        }

        @SuppressWarnings("unchecked")
        public Builder not(String filterField, String value) {
            List<Map<String,Object>> notList = null;

            for (Map<String, Object> map : and) {
                if (map.containsKey("not")) {
                    notList = (List<Map<String, Object>>) map.get("not");
                    break;
                }
            }

            if (notList == null) {
                notList = new ArrayList<>();
                Map<String, Object> notMap = new HashMap<>(initialCapacity);
                notMap.put("not", notList);
                and.add(notMap);
            }

            Map<String, Object> map = new HashMap<>(initialCapacity);
            map.put(filterField, value);
            notList.add(map);

            return this;
        }

        @SuppressWarnings("unchecked")
        public Builder orNot(String filterField, String value) {
            List<Map<String,Object>> orList = null;
            //判断and list里面存不存在key为or的map
            for (Map<String, Object> map : and) {
                if (map.containsKey("or")) {
                    orList = (List<Map<String,Object>>) map.get("or");
                    break;
                }
            }
            //and list里面不存在key为or的map，则新建一个map
            if (orList == null) {
                orList = new ArrayList<>();
                Map<String, Object> orMap = new HashMap<>(initialCapacity);
                orMap.put("or",orList);
                and.add(orMap);
            }

            Map<String, Object> notMap = new HashMap<>(initialCapacity);
            Map<String, Object> filterFieldAndValueMap = new HashMap<>(initialCapacity);
            filterFieldAndValueMap.put(filterField, value);
            notMap.put("not", filterFieldAndValueMap);
            orList.add(notMap);

            return this;
        }

        public Filter build() {
            return new Filter(this);
        }

    }



}
