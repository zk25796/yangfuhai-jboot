/**
 * Copyright (c) 2015-2018, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package aop;

import com.google.inject.Inject;
import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import service.CategoryService;

import javax.inject.Named;


@RequestMapping("/aop")
public class AopDemo extends JbootController {


    public static void main(String[] args) {
//        Jboot.setBootArg("jboot.server.type", "jetty");
        Jboot.setBootArg("jboot.metric.url", "/metrics_admin");
        Jboot.setBootArg("jboot.metric.reporter", "slf4j");
        Jboot.run(args);
    }

    @Inject
    private CategoryService service;

    @Inject
    @Named("myCategory")
    private CategoryService nameservice;


    public void index() {

        renderHtml("service:" + service.hello("") + "<br /> nameservice:" + nameservice.hello(""));
    }


}
