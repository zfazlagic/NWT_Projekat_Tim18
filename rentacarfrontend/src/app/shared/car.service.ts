
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CarModel } from '../models/carModel';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
  export class CarService {
    constructor(private http: HttpClient) { }

  
  getCars(): Observable<CarModel[]>{
    return this.http.get('http://localhost:8082/cars/all').pipe(map((res: CarModel[]) => {
      console.log(res);
      return res;
    }));
  }
   
}


