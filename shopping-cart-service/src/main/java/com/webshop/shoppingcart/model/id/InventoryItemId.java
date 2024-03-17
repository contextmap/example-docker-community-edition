package com.webshop.shoppingcart.model.id;

import com.webshop.shoppingcart.model.common.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InventoryItemId extends EntityId implements Serializable {

    @Column(name = "inventory_item_id")
    private String value;

    public static InventoryItemId fromString(String value) {
        return new InventoryItemId(value);
    }

}
