import {Address} from "./address";

export interface Client {
  id: number,
  name: string,
  surname: string,
  pesel: string,
  email: string,
  dateOfBirth: string,
  phone: string,
  addressDto: Address,
  accountCreated: string
}
