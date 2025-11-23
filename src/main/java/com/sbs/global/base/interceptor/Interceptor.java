package com.sbs.global.base.interceptor;

import com.sbs.global.base.rq.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
