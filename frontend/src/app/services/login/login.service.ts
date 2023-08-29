import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loggedIn: boolean = true
  userRole: string = 'USER' // ADMIN/USER
  isLogged(): boolean {
    return this.loggedIn;
  }
  isAdmin(): boolean {
    return this.isLogged() && this.userRole === 'ADMIN'
  }
  isUser(): boolean {
    return this.isLogged() && this.userRole === 'USER'
  }
  constructor() { }
}
export const authGuard = () => false
