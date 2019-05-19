import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  slides: any[];

  constructor() { }

  ngOnInit() {
    this.slides = [
      {
        "title": "Audi A6",
        "description": "Default desc",
        "imgUrl": "../../assets/images/cars/audi.jpg"
      },
      {
        "title": "Mercedes E Class",
        "description": "Default desc",
        "imgUrl": "../../assets/images/cars/mercedes.jpg"
      },
      {
        "title": "BMW 5 Series",
        "description": "Default desc",
        "imgUrl": "../../assets/images/cars/bmw.jpg"
      }
    ];
  }

}
