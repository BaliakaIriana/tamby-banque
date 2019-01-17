create or replace view detailcompte as
select c.IDCOMPTE, c.IDDEVISE, c.IDCLIENT, c.IDBANQUE, c.OUVERTURE, c.CLOTURE, b.NOM as NOMBANQUE, d.NOM as NOMDEVISE, d.CODE as CODEDEVISE,
      C2.NOM, C2.PRENOM, C2.LOGIN
from COMPTE c
                join BANQUE b on b.IDBANQUE = c.IDBANQUE
                join DEVISE D on c.IDDEVISE = D.IDDEVISE
                join CLIENT C2 on c.IDCLIENT = C2.IDCLIENT;