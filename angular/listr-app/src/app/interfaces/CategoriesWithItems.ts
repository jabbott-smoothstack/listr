import { Item } from "./ItemInterface";

export interface CategoriesWithItems {
    categoryId: Number,
    categoryName: String,
    categoryListId: Number,
    items: Item[]
}