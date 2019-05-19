import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CarsComponent } from './cars/cars.component';
import { CarDetailsComponent } from './cars/car-details/car-details.component';
import { HelpComponent } from './help/help.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CarsComponent,
    CarDetailsComponent,
    HelpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CarouselModule.forRoot(),    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
