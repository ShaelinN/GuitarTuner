<script>
    let allNotes = ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"]
    const CONCERT_PITCH = 440;

    function noteOfPitch(pitch) {
        if (pitch == 0) { 
            return "_"; 
        } 
        var hsteps = Math.trunc(Math.log2(pitch/CONCERT_PITCH) * 12)
        var letter = allNotes[mod(hsteps, 12)]
        var number = 4 + Math.trunc ((hsteps + 9) / 12)
        return letter + number.toString()
    }

    function mod(n, m) {
        return ((n % m) + m) % m;
    }



    let audioContext;
    let ml5ModelUrl = 'https://cdn.jsdelivr.net/gh/ShaelinN/ML5PitchDetectionModel/ml5_crepe/model/';
    let pitch;
    let stream;
    let value = "0.0";
    $: note = noteOfPitch(value);

    async function setup() {
        audioContext = new AudioContext();

        stream = await navigator.mediaDevices.getUserMedia({video:false, audio:true});

        startPitch(stream, audioContext);
    }
    
    function startPitch(stream, audioContext) {
        pitch = ml5.pitchDetection(ml5ModelUrl, audioContext, stream, modelLoaded);
    }

    function modelLoaded() {
        pitch.getPitch(gotPitch);
    }

    function gotPitch(err, frequency) {
        if (err) {
            console.error(err);
            value = 0.0;
        } else if (frequency) {
            console.log(frequency);
            value = frequency;
        } else {
            console.log(0.0);
            value = 0.0;
        }
        pitch.getPitch(gotPitch);
    }








    
 
</script>

<button on:click={setup}>Click to begin pitch detection</button>
<p id="pitch-value-variable">{value}</p>
<h1>{note}</h1>
