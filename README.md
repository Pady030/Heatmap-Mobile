# 🚀 Heatmap Mobile v1.2
**Professional MBO Orderflow Scalping for Android**

![Platform](https://img.shields.io/badge/Platform-Android-brightgreen)
![Device](https://img.shields.io/badge/Optimized-S25_Slim_120Hz-blue)
![API](https://img.shields.io/badge/Data-Rithmic_MBO-orange)

Heatmap Mobile ist ein hochperformantes Trading-Terminal, das institutionelle Orderflow-Daten direkt auf dein Smartphone bringt. Entwickelt für Millisekunden-Entscheidungen im NQ (Nasdaq) und ES (S&P 500).

---

## 💎 Key Features

### 1. 📊 MBO Heatmap & 3D Bubbles
* **Visual Liquidity:** Echtzeit-Visualisierung der Markttiefe (Level 2) mit dynamischen Cyan-Shadern.
* **Volume Bubbles:** 3D-gerenderte Kreise zeigen aggressive Market-Orders. Größe = Volumen, Farbe = Seite.
* **120Hz Rendering:** Flüssiges Scrollen ohne Verzögerung, optimiert für OLED-Displays.

### 2. 🧠 Manipulation Detection (Anti-Spoofing)
* **Ghost-Order Tracking:** Erkennt, wenn große Limit-Orders gelöscht werden, bevor der Preis sie erreicht.
* **Visual X-Indicator:** Ein oranges Warn-X erscheint sofort neben dem Market Pulse bei erkanntem Spoofing.

### 3. 📳 Haptic Intelligence (Delta-Divergence)
* **Feel the Market:** Nutzt den Vibrationsmotor für taktiles Feedback.
* **Divergence-Alert:** Spüre sofort, wenn der Preis steigt, aber das Delta (Kauf-Aggression) sinkt.
* **Absorption-Pulse:** Ein spezifisches Muster bei massiver Absorption an Key-Levels.

### 4. 🛡️ Risk Management (Prop-Firm Ready)
* **Drawdown Protection:** Integrierter Risk-Manager für Apex, Bulenox und MyFundedFutures.
* **P&L Pill:** Dynamische Anzeige des aktuellen Gewinns/Verlusts mit Auto-Lock bei Erreichen des Tageslimits.
* **Emergency Flatten:** Schnelles Schütteln des Handys (Shake-to-Exit) schließt sofort alle Positionen.

---

## 🛠️ Technische Installation

1. **Repository clonen:** `git clone https://github.com/Pady030/Heatmap-Mobile.git`
2. **Library Setup:**
   Füge deine `rithmic-connector.jar` in den Ordner `/app/libs/` ein.
3. **Build:**
   Öffne das Projekt in Android Studio (Iguana oder neuer) und klicke auf 'Sync Project with Gradle Files'.
4. **Deploy:**
   Verbinde dein S25 Slim und drücke 'Run'.

---

## 📡 Connectivity
* **Gateways:** Optimiert für Chicago (CME) Aurora Data Center.
* **Protocols:** Nutzt Rithmic RAPI+ für minimale Latenz über 5G/Fiber.

---
*Disclaimer: Trading involves significant risk. This software is a tool for data visualization and does not guarantee profits.*
