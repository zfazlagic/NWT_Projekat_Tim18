
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Car } from '../models/car';


@Injectable({
  providedIn: 'root'
})
export class CarService {

  carDetailsUrl = 'http://localhost:8082/carDetails/all';

  constructor(private http: HttpClient) { }


  getCars(): Observable<Car[]> {
    return this.http.get(this.carDetailsUrl).pipe(map((res: Car[]) => {
      console.log(res);
      return res;
    }));
  }

}


