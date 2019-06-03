import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from '../shared/user.service';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private userService: UserService, private router:Router){

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      
      if(this.userService.Role()=="admin"){
        return true;
      }else{
        window.alert("You don't have permission to view this page. Just admin can view this page.");
        this.router.navigate(['/welcome']); 
          return false;
      }
  

}
}
