package org.zerhusen.eniity;

import lombok.Data;
import org.zerhusen.utils.JsonUtils;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author Lany
 */
@Data
public class Result implements Serializable {
   private int code;
   private String msg;
   private Object data;

   public Result setCode(int code) {
      this.code = code;
      return this;
   }

   public Result setMsg(String msg) {
      this.msg = msg;
      return this;
   }

   public Result setData(Object data) {
      this.data = data;
      return this;
   }

   @Override
   public String toString() {
      return JsonUtils.object2json(this);
   }
}
