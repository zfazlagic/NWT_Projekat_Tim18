import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

 
  adminVisible: string;
  visible: boolean;
  constructor(private userService: UserService, private router: Router) {
    
   }

  ngOnInit() {
    this.userService.loggedIn$.subscribe((loggedIn: boolean) => {
      this.visible = loggedIn;
  });
  this.userService.role$.subscribe((role:string)=>{
    this.adminVisible = role;
    console.log(role);
  });
  
}


logOut() {
this.userService.signOut();
this.visible=false;
}
}
