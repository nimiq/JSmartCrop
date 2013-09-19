JSmartCrop
==========
Il programma è finalizzato alla ottimizzazione di immagini scansionate, in particolare al taglio dei bordi neri.
Vengono utilizzate diverse tecniche per l'identificazione dei bordi neri: alcune tenciche classiche di computer vision (come operazioni morfologiche di opening e closing e il riconoscimento delle componenti connesse); un test statistico basato sugli standard scores.

La parte di computer vision viene fornita da alcune librerie esterne (ImageJ, Fast_Morphology, ijblob) e alcuni script che ho trovato in rete e che ho migliorato (sono raccolti in lib/src/*).
La parte statistica, così come tutto il resto è stato interamente scritto da me.