import { IUser } from '@/shared/model/user.model';

import { BadgeType } from '@/shared/model/enumerations/badge-type.model';
export interface IBadge {
  id?: string;
  badge?: string | null;
  badgeType?: BadgeType | null;
  count?: number | null;
  user?: IUser | null;
}

export class Badge implements IBadge {
  constructor(
    public id?: string,
    public badge?: string | null,
    public badgeType?: BadgeType | null,
    public count?: number | null,
    public user?: IUser | null
  ) {}
}
