/*
 * Copyright (C) Scott Cranton, Jakub Korab, and Christian Posta
 * https://github.com/CamelCookbook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// saving testing by venerari part2
package org.camelcookbook.structuringroutes.routecontrol;

import org.apache.camel.builder.RouteBuilder;

public class RouteStartupRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:receiveOrders").startupOrder(20)
            .to("seda:processOrders");

        from("seda:processOrders").startupOrder(10)
            .process(new OrderProcessor());
    }
}
