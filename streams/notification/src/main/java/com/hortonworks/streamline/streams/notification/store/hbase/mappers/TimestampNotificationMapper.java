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
package com.hortonworks.streamline.streams.notification.store.hbase.mappers;

import com.hortonworks.streamline.streams.notification.Notification;

import java.util.Arrays;
import java.util.List;

/**
 * A mapper that indexes notifications based on ts.
 * i.e. ts:notification_id_suffix -> Notification
 */
public class TimestampNotificationMapper extends NotificationIndexMapper {
    /**
     * The HBase index table
     */
    private static final String TABLE_NAME = "Timestamp_Notification";
    /**
     * The notification field that is indexed
     */
    private static final List<String> INDEX_FIELD_NAMES = Arrays.asList("ts");

    @Override
    protected List<byte[]> getRowKeys(Notification notification) {
        return Arrays.asList(getIndexSuffix(notification).getBytes(CHARSET));

    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<String> getIndexedFieldNames() {
        return INDEX_FIELD_NAMES;
    }
}
