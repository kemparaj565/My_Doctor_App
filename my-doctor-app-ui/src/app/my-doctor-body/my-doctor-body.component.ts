import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatAutocompleteSelectedEvent, MatAutocomplete} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

export interface Disease{
  id: number;
	diseaseName: string;
	symptom: string;
	diseaseDescription: string;
	durationOfDisease: number;
}


@Component({
  selector: 'my-doctor-body',
  templateUrl: './my-doctor-body.component.html',
  styleUrls: ['./my-doctor-body.component.css']
})
export class MyDoctorBodyComponent implements OnInit {


  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  
  httpHeader: HttpHeaders;

  constructor(private _formBuilder: FormBuilder,private http: HttpClient) {
    this.filteredFruits = this.fruitCtrl.valueChanges.pipe(
      startWith(null),
      map((fruit: string | null) => fruit ? this._filter(fruit) : this.allDiseases.slice()));
   }

  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['']
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['']
    });
  }

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: '#eee'},
    {text: 'Two', cols: 4, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 3, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  phoneFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  gender: string[] = ['Male', 'Female', 'Trans-Gender', 'Won\'t Reveal'];

  startDate = new Date(1975, 0, 1);

  showFiller = false;

  value = 'Clear me';

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  fruitCtrl = new FormControl();
  filteredFruits: Observable<string[]>;
  fruits: string[] = ['Common Cold'];
  //allFruits: string[] = this.diseaseList;
  diseases: Disease[] = this.getDiseaseData();
  diseaseList: string[]=new Array();
  allDiseases: string[] = this.diseaseList;



  @ViewChild('fruitInput') fruitInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete: MatAutocomplete;

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our fruit
    if ((value || '').trim()) {
      this.fruits.push(value.trim());
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }

    this.fruitCtrl.setValue(null);
  }

  remove(fruit: string): void {
    const index = this.fruits.indexOf(fruit);

    if (index >= 0) {
      this.fruits.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.fruits.push(event.option.viewValue);
    this.fruitInput.nativeElement.value = '';
    this.fruitCtrl.setValue(null);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allDiseases.filter(fruit => fruit.toLowerCase().indexOf(filterValue) === 0);
  }

  
  public getDiseaseData(){
    this.http.get<Disease[]>('http://localhost:8080/list-diseases').subscribe(data => {
     this.diseases = data;
  }); 
  return this.diseases;
}


public getDiseasesList(): string[]{
  for( var i of this.diseases )
{
   this.diseaseList.push(i.diseaseName);
}
alert(this.diseaseList);
return this.diseaseList;
}

}
