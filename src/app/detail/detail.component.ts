import { HttpClient } from '@angular/common/http';
import { Component, DebugElement, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
userdata:any
  userdata1:[] | undefined;
  frieghtId: any;
  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient, private activatedRoute: ActivatedRoute) {
      this.activatedRoute.queryParams.subscribe(params => {
        this.driverId = params['driverId'];
        console.log( this.driverId); // Print the parameter to the console.
    });
    }
  driverId(driverId: any) {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.frieghtId = params['frieghtId'];
      console.log( this.frieghtId); // Print the parameter to the console.
  });

  this.getData();
  }

  getData() {
    this.http.post<any>(`http://localhost:7777/getDetails  `,{frieghtId: this.frieghtId}).subscribe(res=>{
        console.log(res);
        this.userdata = res;
      })
  }

  goback() {
    this.router.navigate(
      ['/app-weekly-summary'],
      { queryParams: { driverId: this.driverId } }
    );
  }

}


