/**
  * Copyright 2017 Hortonworks.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at

  *   http://www.apache.org/licenses/LICENSE-2.0

  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
 **/
package com.hortonworks.streamline.streams.runtime.storm.spout;

import java.nio.ByteBuffer;

/**
 * Created by pbrahmbhatt on 7/30/15.
 */
public class NestMessage {
    private Long userId;
    private Long temperature;
    private Long eventTime;
    private Long longitude;
    private Long latitude;

    //for jackson
    public NestMessage() {

    }

    public int size() {
        return 8 + 8 + 8 + 8 + 8;
    }

    public byte[] serialize() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(size());
        byteBuffer.putLong(userId);
        byteBuffer.putLong(temperature);
        byteBuffer.putLong(eventTime);
        byteBuffer.putLong(longitude);
        byteBuffer.putLong(latitude);
        return byteBuffer.array();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public NestMessage(Long userId, Long temperature, Long eventTime, Long longitude, Long latitude) {
        this.userId = userId;
        this.temperature = temperature;
        this.eventTime = eventTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
