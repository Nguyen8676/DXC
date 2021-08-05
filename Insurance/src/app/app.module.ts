import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule,HttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ClaimListComponent } from './claim/claim-list/claim-list.component';
import { AppRoutingModule } from './/app-routing.module';
import { ClaimServiceService } from './service/claim-service.service';
import { CreateClaimComponent } from './claim/create-claim/create-claim.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpdateClaimComponent } from './claim/update-claim/update-claim.component';
import { FileService} from './service/file.service';
import { MotorServiceService } from './service/motor-service.service';
import { MessageServiceService } from './service/message-service.service';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';


export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', 'en.json');
}
@NgModule({
  declarations: [
    AppComponent,
    ClaimListComponent,
    CreateClaimComponent,
    UpdateClaimComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    TranslateModule.forRoot({
    
      loader: {
          provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
      }
  })

  ],
  providers: [ClaimServiceService,FileService,MotorServiceService,MessageServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
