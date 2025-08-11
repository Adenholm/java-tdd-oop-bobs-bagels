| Class            | Member             | Method                       | Scenario                     | Output     |
|------------------|--------------------|------------------------------|------------------------------|------------|
| Basket           | List<Item> items   | add(String sku)              | Correct code basket not full | 1          | 
|                  | int capacity       |                              | Correct code basket full     | 0          |
|                  | static stdCapacity |                              | Incorrect code               | -1         |
|                  | static Stock stock | remove(String sku)           | Exists                       | True       |
|                  |                    |                              | Doesn't exist                | False      |
|                  |                    | getTotalCost()               |                              | float      |
|                  |                    | getDiscountedCost()          |                              | float      |
| Stock            | List<Item> stock   |                              |                              |            |
|                  |                    | getPrice(String sku)         | Exists                       | float      |
|                  |                    |                              | Doesn't exist                | -1         |
|                  |                    | getFillings()                |                              | List<Item> |
|                  |                    | getItem(String sku)          | Exists                       | Item       |
|                  |                    |                              | Does not exist               | null       |
| Abstract Item    | String sku         | getSku()                     |                              | sku        |
|                  | float price        | getPrice()                   |                              | price      |
|                  | String name        | getName()                    |                              | name       |
|                  | String variant     | getVariant()                 |                              | variant    |
|                  |                    |                              |                              |            |
| Bagel            | List<Filling>      | addFilling(String "variant") |                              | void       |
|                  |                    | removeFilling("variant")     |                              |            |
| Coffee           |                    |                              |                              |            |
| Filling          |                    |                              |                              |            |



### Extension 1
```
As a cutomer,
So I know what the price will be,
I'd like to know the total discounted price
```