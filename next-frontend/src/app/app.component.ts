import {Component, OnInit} from '@angular/core';
import {StopService} from "./service/StopService";
import {StopDTO} from "./model/StopDTO";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'app';
  stops: StopDTO[] = [];

  constructor(private stopService: StopService) {
  }

  ngOnInit(): void {
    this.stopService
      .findStopsByRadius({lat: '47.174793', lon: '18.941817'}, '10000')
      .subscribe(data => {
        this.stops = data;
        console.log(this.stops)
      },
      error => {
        console.log(error.message)
      });

    this.stopService.findAll().subscribe( data => {
      console.log(data)
    })
  }
}
