import { Component, OnInit, Input, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';
import {CollectionViewMode} from '../collection-list/collection-view-mode';

@Component({
  selector: 'app-collection-form',
  templateUrl: './collection-form.component.html',
  styleUrls: ['./collection-form.component.css']
})
export class CollectionFormComponent implements OnInit, AfterViewInit {

  @Input() collectionView: CollectionView;
  @ViewChild('input1') inputEl: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.inputEl.nativeElement.focus();
  }

  synchCollection(): void {
    // Todo: Servercall
  }

  submitChanges(): void {
    // Todo: Servercall
    this.collectionView.save();
  }
}
