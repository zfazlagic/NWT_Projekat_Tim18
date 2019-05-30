import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../shared/user.service';
import { User } from '../models/user';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  user:  User;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
  });
  this.user= new User("username","passworddd","client");
  }
  get f() { return this.registerForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.registerForm.invalid) {
          return;
      }

      this.loading = true;
     
     
     this.userService.createUser(this.user)
          .pipe(first())
          .subscribe(
              data => {
                window.alert("Success");
                  
              },
              error => {
                window.alert("Error");
                  this.loading = false;
              });
  } 

}

