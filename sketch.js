let audioContext;
let mic;
let pitch;
let modelUrl = 'https://cdn.jsdelivr.net/gh/ShaelinN/GuitarTuner/ml5_crepe/model/'

function setup() {
  noCanvas();
  select('#enable').mousePressed(function() {
    try {
      audioContext = getAudioContext();
      mic = new p5.AudioIn();
      mic.start(startPitch);
      select('#enable').remove();
    } catch (err) {
      console.error(err);
      select('#status').html('Unable to enable audio');
    }
  });
}


function touchStarted() {
  getAudioContext().resume();
}

function startPitch() {
  pitch = ml5.pitchDetection(modelUrl, audioContext, mic.stream, modelLoaded);
}
let loaded=false;
function modelLoaded() {
  try {
    getPitch()
    loaded=true;
  } catch {
    loaded=false;
  }
}

function getPitch() {
  pitch.getPitch(function(err, frequency) {
    if (err) {
      console.error("err="+err)
    } else {
        if (frequency) {
          console.log(frequency)
          select('#result').html(toNote(frequency));
        } else {
          select('#result').html('No pitch detected');
        }
    }
    getPitch()
  })
}

let notes = ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"]
const CONCERT_PITCH = 440;

function toNote(pitch) {
  hsteps = Math.trunc(Math.log2(pitch/CONCERT_PITCH) * 12)
  letter = notes[mod(hsteps, 12)]
  number = 4 + Math.trunc ((hsteps + 9) / 12)
  return letter + number.toString()
}

function mod(n, m) {
  return ((n % m) + m) % m;
}
