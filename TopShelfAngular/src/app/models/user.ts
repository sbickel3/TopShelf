import { Chef } from "./chef";
import { Fridge } from "./fridge";
import { Grocery } from "./grocery";

export class User {
    chef: Chef;
    fridge: Fridge;
    grocery: Grocery;
}