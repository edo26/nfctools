/**
 * Copyright 2011 Adrian Stabiszewski, as@nfctools.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nfctools.spi.arygon;

import java.io.IOException;

import org.nfctools.io.ByteArrayWriter;

/**
 * Writer for the Arygon low Level protocol. Adds 0x32 ('2') before every message.
 * 
 */
public class ArygonLowLevelWriter implements ByteArrayWriter {

	private byte[] prefix = { 0x32 };
	private ByteArrayWriter writer;

	public ArygonLowLevelWriter(ByteArrayWriter writer) {
		this.writer = writer;
	}

	@Override
	public void write(byte[] data, int offset, int length) throws IOException {
		// TODO must write the data as one method call otherwise the contract is violated. 
		writer.write(prefix, 0, prefix.length);
		writer.write(data, offset, length);
	}
}