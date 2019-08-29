package org.nervos.ckb.type;

/** Copyright © 2019 Nervos Foundation. All rights reserved. */
public class Byte32 implements Type<byte[]> {

  private byte[] value;

  public Byte32(byte[] value) {
    if (value.length != 4) {
      throw new UnsupportedOperationException("Byte32 length error");
    }
    this.value = value;
  }

  @Override
  public byte[] toBytes() {
    return value;
  }

  @Override
  public byte[] getValue() {
    return value;
  }
}
