# Gestió de Lloguer de Videojocs

Pràctica de Desenvolupament d'Interfícies (DAM). És una aplicació feta amb Java Swing i NetBeans per portar el lloguer de videojocs: usuaris, jocs i lloguers. Les dades es guarden en memòria, així que quan es tanca l'aplicació es perden.

## Com executar-la

1. Obrir els projectes `ValidationAPI` i `GestioLloguers` amb NetBeans.
2. Fer Clean and Build de `ValidationAPI` (és la llibreria de validacions que fa servir l'aplicació).
3. Executar `GestioLloguers` (F6).

## Dades inicials

Quan s'obre l'aplicació ja hi ha unes quantes dades per poder provar-ho tot:

- Usuaris: Laura García i Marc López.
- Jocs: Minecraft (PS5 i Switch 2) i Cyberpunk 2077 (Xbox i PC).
- Dos lloguers: un de Minecraft per a la Laura, que ja està fora de termini (surt en vermell), i un de Cyberpunk per al Marc, que és d'avui.

## Coses a tenir en compte

- Els lloguers duren 7 dies i les dates es posen soles.
- Si un lloguer s'ha passat de data surt en vermell, i quan es retorna surt en verd.
- No es pot llogar una plataforma sense unitats, ni esborrar usuaris o jocs que tinguin lloguers actius.
- Els noms han de començar amb majúscula.
