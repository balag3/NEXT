import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Location} from "../model/Location";
import {Observable} from "rxjs";

@Injectable()
export class StopService {

  private readonly BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  findAll() {
    return this.http.get(this.BASE_URL + '/stop');
  }

  findStopsByRadius(center: Location, radius: string): Observable<any> {
    const {'lat':lat, 'lon':lon} = center;
    //return this.http.get(this.BASE_URL + '/lat/'+lat+'/lon/'+lon+'/radius/' + radius);
    return this.http.get(this.BASE_URL + '/stop/centerLat/'+lat+'/centerLon/'+lon+ '/radius/'+radius);
  }
}
