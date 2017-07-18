package sample.dao;

import sample.dto.ItemDto;

/**
 * Created by jaliya on 7/14/17.
 */

/**
 * providing an abstraction for the item related data
 */
public interface ItemDao {

     ItemDto createItem(ItemDto itemDto);
}
