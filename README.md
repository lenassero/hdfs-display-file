# hdfs-display-file
The two progams are intended to display the content of files using the HDFS API:

1. ```display_csv```: We display the year and height of each tree of a csv file describing the [amazing trees of Paris](https://opendata.paris.fr/explore/dataset/les-arbres/).

The input looks like the following:

```csv
GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV,,,,,
(48.857140829,2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly,avenue de La Motte-Piquet,avenue de la Bourdonnais,avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars,
(48.8685686134,2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine,avenue Franklin-D.-Roosevelt,avenue Matignon,avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées,
```

and the ouput:

```
Displaying output of arbres.csv
Year: 1935, Height: 13.0
Year: 1854, Height: 20.0
Year: 1862, Height: 22.0
...
```

2. ```display_compact```: We display the USAF code, the name, the country (FIPS country ID) and the elevation of each station for [this data](https://www1.ncdc.noaa.gov/pub/data/noaa/isd-history.txt) from the National Oceanic and Atmospheric Administration (NOAA).

Here are some lines taken from the output:

```
...
USAF_code: 999999, Name: FORT CAMPBELL AAF, Country_ID: US, Elevation: +0174.7
USAF_code: 999999, Name: LOCKBOURNE, Country_ID: US, Elevation: +0226.8
USAF_code: 999999, Name: ALBANY NAVAL AIR STN, Country_ID: US, Elevation: +0066.1
USAF_code: 999999, Name: GREENVILLE DONALDSON AFB, Country_ID: US, Elevation: +0298.1
USAF_code: 999999, Name: COLUMBUS AAF, Country_ID: US, Elevation: +0066.8
...
```
