export enum CollectionViewMode {
  /* Collection is closed, only header is shown */
  CLOSED = 0,
  /* Collection details are shown */
  VIEW = 1,
  /* Collection is currently edited */
  EDIT = 2,
  /* Collection is still in creation */
  NEW = 3,
  /* Collection was in creation but creation has been discarded */
  NEW_DISCARDED = 4
}
