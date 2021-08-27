package org.nervos.mercury.model.req;

import org.nervos.mercury.model.req.item.Item;

public class From {

  public Item item;

  public Source source;

  public From(Item item, Source source) {
    this.item = item;
    this.source = source;
  }

  public static From newFrom(Item item, Source source) {
    return new From(item, source);
  }
}
