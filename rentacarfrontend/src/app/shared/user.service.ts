
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
  export class UserService {

    constructor(private http: HttpClient) { }

    createUser(user: User){ 
        let body=JSON.stringify(user);
        return this.http.post('http://localhost:8081/users/new', body
    ).pipe(map((res: Response) => {
        if ( res['errcode'] !== '00000') {
          return [];
        }
    }));
}
  }

   
    


