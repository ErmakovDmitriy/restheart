/*-
 * ========================LICENSE_START=================================
 * restheart-commons
 * %%
 * Copyright (C) 2019 - 2020 SoftInstigate
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * =========================LICENSE_END==================================
 */
package org.restheart.handlers.exchange;

import org.bson.BsonDocument;
import org.bson.BsonValue;

/**
 *
 * @author Andrea Di Cesare {@literal <andrea@softinstigate.com>}
 */
public class OperationResult {
    private final int httpCode;
    private final Object etag;
    private final BsonDocument newData;
    private final BsonDocument oldData;
    private final BsonValue newId;
    
    /**
     *
     * @param httpCode
     */
    public OperationResult(int httpCode) {
        this.httpCode = httpCode;
        this.etag = null;
        this.newData = null;
        this.oldData = null;
        this.newId = null;
    }
    
    /**
     *
     * @param httpCode
     * @param oldData
     * @param newData
     */
    public OperationResult(int httpCode, BsonDocument oldData, BsonDocument newData) {
        this.httpCode = httpCode;
        this.etag = null;
        this.newData = newData;
        this.oldData = oldData;
        this.newId = newData == null ? null : newData.get("_id");
    }
    
    /**
     *
     * @param httpCode
     * @param etag
     */
    public OperationResult(int httpCode, Object etag) {
        this.httpCode = httpCode;
        this.etag = etag;
        this.newData = null;
        this.oldData = null;
        this.newId = null;
    }
    
    /**
     *
     * @param httpCode
     * @param etag
     * @param newId
     */
    public OperationResult(int httpCode, Object etag, BsonValue newId) {
        this.httpCode = httpCode;
        this.etag = etag;
        this.newId = newId;
        this.newData = null;
        this.oldData = null;
    }
    
    /**
     *
     * @param httpCode
     * @param etag
     * @param oldData
     * @param newData
     */
    public OperationResult(int httpCode, Object etag, 
            BsonDocument oldData, BsonDocument newData) {
        this.httpCode = httpCode;
        this.etag = etag;
        this.newData = newData;
        this.oldData = oldData;
        this.newId = newData == null ? null : newData.get("_id");
    }

    /**
     * @return the httpCode
     */
    public int getHttpCode() {
        return httpCode;
    }

    /**
     * @return the etag
     */
    public Object getEtag() {
        return etag;
    }

    /**
     * @return the newData
     */
    public BsonDocument getNewData() {
        return newData;
    }
    
    /**
     * @return the oldData
     */
    public BsonDocument getOldData() {
        return oldData;
    }

    /**
     * @return the newId
     */
    public BsonValue getNewId() {
        return newId;
    }
}
